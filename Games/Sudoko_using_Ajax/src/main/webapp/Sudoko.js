var numbers = document.getElementById("numbers");

var board = document.getElementById("board");

var answer = null;

var started = false;

var row = -1;
var col = -1;

function produceSudoko() {

	for (let i = 0; i < 9; i++) {
		let rows = document.createElement("div");
		for (let j = 0; j < 9; j++) {
			let nums = document.createElement("button");
			nums.className = "mini";
			nums.id = i + "" + j;
			nums.setAttribute("onclick", `inds(${i} , ${j})`);

			nums.innerHTML = "?";

			rows.append(nums);
		}
		board.append(rows);
	}

	let rows = document.createElement("div");
	for (let i = 1; i <= 9; i++) {
		let nums = document.createElement("button");
		nums.className = "nums";

		nums.setAttribute("onclick", `selectedNumber(${i})`);

		nums.innerHTML = i;

		rows.append(nums);
	}
	numbers.append(rows);
}

function inds(row, col) {
	this.row = row;
	this.col = col;
}

function selectedNumber(num) {
	
	if(row < 0 && col <0){
		return;
	}
	
	let node = document.getElementById(row + "" + col);
	
	if (node.innerText != '?'){
		return;
	}

	if(answer[row][col] == num){
		node.innerText = num;
		node.className = "correct";
	}else{
		node.className = "notfound";
	}	
}

document.getElementById("start").addEventListener("click", function() {
	
	if(started){
		return;
	}
	
	started = true;
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);

			let sudoko = res.board;
			answer = res.solution;

			for (let i = 0; i < sudoko.length; i++) {
				for (let j = 0; j < sudoko.length; j++) {
					let number = sudoko[i][j];
					if (number != 0) {
						let node = document.getElementById(i + "" + j);
						node.className = "correct";
						node.innerText = number;
					}
				}
			}
		}
	}
	xhr.open("POST", "http://localhost:8080/Sudoko/startgame");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();
});

document.getElementById("end").addEventListener("click", function() {
	for (let i = 0; i < answer.length; i++) {
		for (let j = 0; j < answer.length; j++) {
			let node = document.getElementById(i + "" + j);
			if (node.innerText == '?') {
				node.className = "notfound";
				node.innerText = answer[i][j];
			}
		}
	}
});
