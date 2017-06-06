app.controller('ExampleController', ['$cookieStore', function($cookieStore) {
  // Put cookie
  $cookieStore.put('myFavorite','oatmeal');
  // Get cookie
  var favoriteCookie = $cookieStore.get('myFavorite');
  // Removing a cookie
  $cookieStore.remove('myFavorite');
}]);










//app.factory('Session', function($http) {
//  var Session = {
//    data: {},
//    saveSession: function() { /* save session data to db */ },
//    updateSession: function() { 
//      /* load data from db */
//      $http.get('session.json').then(function(r) { return Session.data = r.data;});
//    }
//  };
//  Session.updateSession();
//  return Session; 
//});