package com.jdc.mkt.entity.listeners;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TimesListener {

	@PrePersist
	public void createTime(Object obj) {
		if(obj instanceof EnableTimesListener entity) {
			var times = entity.getTimes();
			
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setCreateTime(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	public void updateTime(Object obj) {
		
		if(obj instanceof EnableTimesListener entity) {
			var times = entity.getTimes();
			
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setUpdateTime(LocalDateTime.now());
		}
	}
}
