new Chart(document.getElementById("myPieChart"), {
	 type: 'pie',
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June','July'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            data: [12, 19, 3, 5, 2, 3,23],
 
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});