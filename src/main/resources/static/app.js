var app = (function () {
    var buscar = function (ciudad) {

        axios.get('https://varon-arsw-t2.herokuapp.com/weather/'+ciudad,{
            responseType: 'json'
        })
            .then(response => generarClima(response.data))
            .catch(error => console.log(error));
    }

    var generarClima = (function (clima) {
        $('#weather').empty();
        var tables;
        for (let i = 0; i < clima.weather.length; i++) {
            tables += "<tr> <td>" + clima.weather[i].main + "</td> <td>" + clima.weather[i].description + "</td> </tr>";
        }
        $('#weather').append(tables)

        let temp = document.querySelector('#temp');
        temp.innerHTML = "Temperature: " + clima.main.temp;
        let feels_like = document.querySelector('#feels_like');
        feels_like.innerHTML = "Feels like: " + clima.main.feels_like;
        let temp_min = document.querySelector('#temp_min');
        temp_min.innerHTML = "Low: " + clima.main.temp_min;
        let temp_max = document.querySelector('#temp_max');
        temp_max.innerHTML = "High: " + clima.main.temp_max;
        plotMarkers(clima);

    })

    return {
        buscar: buscar
    }
})();