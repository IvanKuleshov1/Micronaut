import React, { useEffect, useState } from 'react';
import axios from 'axios';

const PerformanceDashboard = () => {
    const [performanceData, setPerformanceData] = useState(null);

    useEffect(() => {
        const fetchPerformanceData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/performance');
                setPerformanceData(response.data);
            } catch (error) {
                console.error('Ошибка при получении данных о производительности', error);
            }
        };

        fetchPerformanceData();
    }, []);

    return (
        <div>
            <h2>Производительность</h2>
            {performanceData && (
                <div>
                    <p>Загрузка процессора: {performanceData.cpuLoad}%</p>
                    <p>Использование памяти: {performanceData.memoryUsage} MB</p>
                    <p>Время отклика приложений: {performanceData.responseTime} ms</p>
                </div>
            )}
        </div>
    );
};

export default PerformanceDashboard;