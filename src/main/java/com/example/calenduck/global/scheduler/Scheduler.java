package com.example.calenduck.global.scheduler;

import com.example.calenduck.domain.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

    private final PerformanceService performanceService;

    // 매일 자정 메인페이지(전체 조회) 캐시 업데이트
    @Scheduled(cron = "0 0 0 * * *")
    public void updatePerformancesCache() {
        try {
            performanceService.getAllPerformances(null, null);
        } catch (Exception e) {
            log.error("업데이트 캐시 에러: {}", e.getMessage());
        }
    }

}
