var map;
var marker;
var bounds;
function initMap(){
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 4.782991299132583, lng: -74.04263763693044},
        zoom: 8
    });
}


function markers(m){
    initMap();
    marker=null;
    bounds=new google.maps.LatLngBounds();
    var position = new google.maps.LatLng(m.coord.lat, m.coord.lon);
    marker= new google.maps.Marker({
        position: position,
        map:map,
        animation: google.maps.animation.DROP
    })
    bounds.extend(position);
    map.fitBounds(bounds);
}