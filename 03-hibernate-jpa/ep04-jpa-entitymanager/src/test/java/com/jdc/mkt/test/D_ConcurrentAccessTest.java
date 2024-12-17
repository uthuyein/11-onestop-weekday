package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Account;

public class D_ConcurrentAccessTest extends JpaEntityManagerFactory {

	
	@Test
	void updateTest() throws InterruptedException {

		var first = firstUpdate();
		var second = secondUpdate();
		first.start();
		second.start();

		Thread.sleep(1500);
	}

	private Thread secondUpdate() {
		return new Thread(() -> {
			var em = emf.createEntityManager();
			var acc = em.find(Account.class, 1);

			em.getTransaction().begin();

			System.out.println("==================  ( Second ) Before update transaction ================");
			System.out.println("   =============   Balance : " + acc.getBalance() + "   ==========   ");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			em.refresh(acc);
			acc.setBalance(acc.getBalance() + 3000);
						
			System.out.println("==================  ( Second ) After update transaction ================");
			System.out.println("   =============   Balance : " + acc.getBalance() + "   ==========   ");

			em.getTransaction().commit();
		});

	}

	private Thread firstUpdate() {
		return new Thread(() -> {
			var em = emf.createEntityManager();
			var acc = em.find(Account.class, 1);

			em.getTransaction().begin();

			System.out.println("==================  ( First ) Before update transaction ================");
			System.out.println("   =============   Balance : " + acc.getBalance() + "   ==========   ");			
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acc.setBalance(acc.getBalance() - 5000);
			em.flush();
			
			System.out.println("==================  ( First ) After update transaction ================");
			System.out.println("   =============   Balance : " + acc.getBalance() + "   ==========   ");

			em.getTransaction().commit();
		});
	}
}
