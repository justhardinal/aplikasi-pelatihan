var aplikasiPelatihan = angular.module('aplikasiPelatihan', []);

aplikasiPelatihan.controller('HaloController', function ($scope) {
    $scope.daftarEmail = [
        'hardinal.fahmi@gmail.com',
        'just.hardinal@gmail.com'
    ];

    $scope.tambahEmail = function() {
        $scope.daftarEmail.push($scope.email);
        //$scope.email="";
    };

    $scope.hapusEmail = function(x) {
        var lokasiIndex = $scope.daftarEmail.indexOf(x);
        if (lokasiIndex > -1) {
            $scope.daftarEmail.splice(lokasiIndex, 1);
        };
    };
});

aplikasiPelatihan.controller('MateriController', function($http, $scope) {
    $scope.dataMateri = {};
    
    $scope.simpanMateri = function (){
        $http.post('/api/materi', $scope.materi ).then(sukses, gagal);
        function sukses(response) {
            $scope.UpdateDataMateri();
        };

        function gagal(response) {
            console.log(response);
            alert('error = ' +response);
        };
    };
    
    
    $scope.hapusMateri = function(x){
        $http.delete('/api/materi/'+x.id).then(sukses, gagal);
        function sukses(response) {
            $scope.UpdateDataMateri();
        };

        function gagal(response) {
            console.log(response);
            alert('error = ' +response);
        };
    };
    
    $scope.UpdateDataMateri = function() {
        $http.get('/api/materi').then(sukses, gagal);

        function sukses(response) {
            $scope.dataMateri = response.data;
            console.log($scope.dataMateri);
        };

        function gagal(response) {
            console.log(response);
            alert('error = ' +response);
        };
    };
    
    $scope.UpdateDataMateri();

});
