package com.cashlife.financial_information_microservice.inflationReport.infrastructure.persistence.jpa;

import com.cashlife.financial_information_microservice.inflationReport.domain.model.InflationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InflationReportRepository extends JpaRepository<InflationReport, Long> {
}
