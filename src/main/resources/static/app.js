var app = (function () {
    var buscar = function (ciudad) {

        axios.get('https://varon-arsw-t2.herokuapp.com/weather/'+ciudad,{
            responseType: 'json'
        })
            .then(response => generarClima(response.data))
            .catch(error => console.log(error));
    }

    var generarClima = (function (clima) {
        var obj = JSON.parse(clima);
        $('#weather').empty();
        var tables;
        for (let i = 0; i < obj.weather.length; i++) {
            tables += "<tr> <td>" + obj.weather[i].main + "</td> <td>" + obj.weather[i].description + "</td> </tr>";
        }
        $('#weather').append(tables)

        let temp = document.querySelector('#temp');
        temp.innerHTML = "Temperature: " + obj.main.temp;
        let feels_like = document.querySelector('#feels_like');
        feels_like.innerHTML = "Feels like: " + obj.main.feels_like;
        let temp_min = document.querySelector('#temp_min');
        temp_min.innerHTML = "Low: " + obj.main.temp_min;
        let temp_max = document.querySelector('#temp_max');
        temp_max.innerHTML = "High: " + obj.main.temp_max;
        markers(obj);

    })

    return {
        buscar: buscar
    }
})();