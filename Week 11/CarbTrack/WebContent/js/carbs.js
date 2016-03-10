window.onload = function() {
  console.log("initing");
  init();
}

function init() {
  var button = document.getElementById("loadMeal");
  console.log(button);
  button.addEventListener("click", loadMealClicked);
  var postButton = document.getElementById("newMeal");
  postButton.addEventListener("click", createMealClicked);
}

function createMealClicked(e) {
  e.preventDefault();
  MakeNewMeal();
}

function loadMealClicked(e) {
  e.preventDefault();
  getMeals(displayMeals);
  console.log("In loadMealClicked");
}

function getMeals(func) {
  console.log("in Get Meals");
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "http://52.35.169.157:8080/CarbTrack/rest/meals");
  console.log(xhr.readyState);
  xhr.onreadystatechange = function() {
    console.log(xhr.readyState);
    if (xhr.readyState == 4 && xhr.status < 400) {
      func(JSON.parse(xhr.responseText));
    }
    console.log(xhr.status);
  };
  xhr.send(null);
}

function displayMeals(resp) {
  var existingTable = document.getElementById("mealDisplay");
  if (existingTable != null) {
    clearTable(existingTable);
  }
  var body = document.querySelector("body");
  var table = document.createElement("table");
  table.id = "mealDisplay";
  var theadRow = document.createElement("tr");
  var theader1 = document.createElement("th");
  theader1.innerHTML = "Meal Name";
  theadRow.appendChild(theader1);
  var theader2 = document.createElement("th");
  theader2.innerHTML = "Type of Food";
  theadRow.appendChild(theader2);
  var theader3 = document.createElement("th");
  theader3.innerHTML = "Number of Carbs";
  theadRow.appendChild(theader3);
  table.appendChild(theadRow);
  for (var i = 0; i < resp.length; i++) {
    var trow = document.createElement("tr");
    var td1 = document.createElement("td");
    td1.innerHTML = resp[i].name;
    trow.appendChild(td1);
    var td2 = document.createElement("td");
    td2.innerHTML = resp[i].mealtime;
    trow.appendChild(td2);
    var td3 = document.createElement("td");
    td3.innerHTML = resp[i].carbcount;
    trow.appendChild(td3);
    table.appendChild(trow);
  }
  body.appendChild(table);
}

function MakeNewMeal() {
  var pchecker = document.getElementById("error");
  if (pchecker != null) {
    clearError(pchecker);
  }
  var newMealNameElement = document.getElementById('mealName');
  var newMealName = newMealNameElement.value;
  var newMealTimeElement = document.getElementById('mealTime');
  var newMealTime = newMealTimeElement.value;
  var newMealCarbsElement = document.getElementById('mealCarbs');
  var newMealCarbs = newMealCarbsElement.value;

  if ((newMealName.length === 0 || newMealCarbs.length === 0) || isNaN(newMealCarbs)) {
    var body = document.querySelector("body");
    var p = document.createElement("p");
    p.id = "error";
    p.innerHTML = "Error in input, all fields must be filled in, and Carbs must be an integer";
    body.appendChild(p);
  } else {
    var meal = {};
    meal.name = newMealName;
    meal.mealtime = newMealTime;
    meal.carbcount = newMealCarbs;
    console.log(meal);
    postMeal(meal);
  }
}

function clearError(p) {
  p.parentNode.removeChild(p);
}

function clearTable(table) {
  table.parentNode.removeChild(table);
}

function postMeal(meal) {
  {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://52.35.169.157:8080/CarbTrack/rest/newMeal");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
      console.log(xhr.status);
      console.log(xhr.readyState);
      console.log(xhr.responseText);
      console.log(xhr.getAllResponseHeaders());

    }
    if (meal) {
      xhr.send(JSON.stringify(meal));
    } else {
      xhr.send(null);
    }
  }
}
