var app=(function (){
    var buscar = function (ciudad){

        axios({
            method: 'GET',
            url: '/weather/'+ciudad

        })
            .then(response => generarClima(response.data))
            .catch(error => console.log(error))
    }

    var generarClima=(function (clima){
        $('#weather').empty();
        clima.map(function (tmp){
            var tables;
            for(let i = 0; i < tmp.weather.length; i++) {
                tables += "<tr> <td>"+ tmp.weather[i].main +"</td> <td>"+tmp.weather[i].description+"</td> </tr>";
            }
            $('#weather').append(tables)

            let temp = document.querySelector('#temp');
            temp.innerHTML = "Temperature: "+ tmp.main.temp;
            let feels_like = document.querySelector('#feels_like');
            feels_like.innerHTML = "Feels like: "+ tmp.main.feels_like;
            let temp_min = document.querySelector('#temp_min');
            temp_min.innerHTML = "Low: "+ tmp.main.temp_min;
            let temp_max = document.querySelector('#temp_max');
            temp_max.innerHTML = "High: "+ tmp.main.temp_max;
        })
        markers(clima);

    })

    return{
        buscar:buscar
    }
})();