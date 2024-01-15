import React, { useEffect, useState } from 'react';
import axios from 'axios';

const NetworkActivityDashboard = () => {
    const [networkActivityData, setNetworkActivityData] = useState(null);

    useEffect(() => {
        const fetchNetworkActivityData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/network');
                setNetworkActivityData(response.data);
            } catch (error) {
                console.error('Ошибка при получении данных о сетевой активности', error);
            }
        };

        fetchNetworkActivityData();
    }, []);

    return (
        <div>
            <h2>Сетевая активность</h2>
            {networkActivityData && (
                <div>
                    <p>Пропускная способность сети: {networkActivityData.bandwidth} Mbps</p>
                    <p>Задержки при передаче данных: {networkActivityData.latency} ms</p>
                </div>
            )}
        </div>
    );
};

export default NetworkActivityDashboard;