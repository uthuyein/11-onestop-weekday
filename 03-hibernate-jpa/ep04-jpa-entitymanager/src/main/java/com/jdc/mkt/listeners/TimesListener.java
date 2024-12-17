package com.jdc.mkt.listeners;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TimesListener {

	@PrePersist
	public void prePersist(Object obj) {
		if(obj instanceof EnableTimesListener entity) {
			var times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setCreateDate(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	public void preUpdate(Object obj) {
		
		if(obj instanceof EnableTimesListener entity) {
			var times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setUpdateDate(LocalDateTime.now());
		}
	}
}
