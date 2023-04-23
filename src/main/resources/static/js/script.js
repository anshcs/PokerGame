var Bet = document.getElementById("Bet");
Bet.onclick = function(){
  var xhr = new XMLHttpRequest();
  xhr.open("GET","/game/bet");
  xhr.onload = function() {
    alert("bet placed");
  };
  xhr.send();
}; 

var Fold = document.getElementById("Fold");
Fold.onclick= function(){
  var xhr = new XMLHttpRequest();
  xhr.open("GET","/game/fold");
  xhr.onload =function(){
    if (xhr.status === 200) {
      var player_fold = (xhr.responseText);
      alert(player_fold);
  }
  }
  xhr.send()
}


function updatePot() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/game/pot");
    xhr.onload = function() {
        if (xhr.status === 200) {
            var pot = parseInt(xhr.responseText);
            document.getElementById("pot").innerHTML = pot;
        }
    };
    xhr.send();
}

setInterval(updatePot, 1000); // update pot every second

function updateFlop(){

  
  var getFrank1 = new XMLHttpRequest();
  getFrank1.open("GET", "/table/Flop1rank");
  getFrank1.onload = function() {
    if (getFrank1.status === 200) {
        var Flop1rank = (getFrank1.responseText);
        document.getElementById("flop1rank").innerHTML = Flop1rank;
    }
  };
  getFrank1.send();


  var getFsuit1 = new XMLHttpRequest();
  getFsuit1.open("GET", "/table/Flop1suit");
  getFsuit1.onload = function() {
    if (getFsuit1.status === 200) {
        var Flop1suit = (getFsuit1.responseText);
        document.getElementById("flop1suit").innerHTML = Flop1suit;
    }
  };
  getFsuit1.send();

  var getFrank2 = new XMLHttpRequest();
  getFrank2.open("GET", "/table/Flop2rank");
  getFrank2.onload = function() {
    if (getFrank2.status === 200) {
        var Flop2rank = (getFrank2.responseText);
        document.getElementById("flop2rank").innerHTML = Flop2rank;
    }
  };
  getFrank2.send();
  var getFsuit2 = new XMLHttpRequest();
  getFsuit2.open("GET", "/table/Flop2suit");
  getFsuit2.onload = function() {
    if (getFrank2.status === 200) {
        var Flop2suit = (getFsuit2.responseText);
        document.getElementById("flop2suit").innerHTML = Flop2suit;
    }
  };
  getFsuit2.send();

  var getFrank3 = new XMLHttpRequest();
  getFrank3.open("GET", "/table/Flop3rank");
  getFrank3.onload = function() {
    if (getFrank3.status === 200) {
        var Flop3rank = (getFrank3.responseText);
        document.getElementById("flop3rank").innerHTML = Flop3rank;
    }
  };
  getFrank3.send();

  var getFsuit3 = new XMLHttpRequest();
  getFsuit3.open("GET", "/table/Flop3suit");
  getFsuit3.onload = function() {
    if (getFsuit3.status === 200) {
        var Flop3suit = (getFsuit3.responseText);
        document.getElementById("flop3suit").innerHTML = Flop3suit;
    }
  };
  getFsuit3.send();



}
setInterval(updateFlop, 1000);