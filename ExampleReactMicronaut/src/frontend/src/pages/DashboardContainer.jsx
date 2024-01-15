import React from 'react';
import PerformanceDashboard from '../components/PerformanceDashboard/PerformanceDashboard';
import NetworkActivityDashboard from '../components/NetworkActivityDashboard/NetworkActivityDashboard';
import ResourceUsageDashboard from '../components/ResourceUsageDashboard/ResourceUsageDashboard';
import SecurityDashboard from '../components/SecurityDashboard/SecurityDashboard';
import AvailabilityDashboard from '../components/AvailabilityDashboard/AvailabilityDashboard';
import PowerConsumptionDashboard from '../components/PowerConsumptionDashboard/PowerConsumptionDashboard';
import ComplianceDashboard from '../components/ComplianceDashboard/ComplianceDashboard';

const DashboardContainer = () => {
    return (
        <div>
            <PerformanceDashboard />
            <NetworkActivityDashboard />
            <ResourceUsageDashboard />
            <SecurityDashboard />
            <AvailabilityDashboard />
            <PowerConsumptionDashboard />
            <ComplianceDashboard />
        </div>
    );
};

export default DashboardContainer;