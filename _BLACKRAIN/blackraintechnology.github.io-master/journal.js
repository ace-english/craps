var array = [];
var totalProfit=0.0;
var tableExists=false;

//The structure where it all goes down
function trade(ticker, entry, exit, quantity)
{
    this.ticker=ticker;
    this.entry=parseFloat(entry).toFixed(2);	//converts into pretty 2 decimal display
    this.exit=parseFloat(exit).toFixed(2);
    this.quantity=parseInt(quantity);
    this.cost=(quantity*entry).toFixed(2);
    this.gross=(quantity*exit).toFixed(2);
    this.profit=this.gross-this.cost;
    totalProfit+=this.profit;			//this is probably reduntant at this point

//VERY IMPORTANT - when a new object is created it gets stored onto array[]
    array.push(this);
};

//This function adds the information currently entered into the textboxes on the webpage into the array. It then links to the function that prints the table.
function save()
{

//retrieve into from user
    var ticker= document.getElementById("ticker").value;
    var entry= document.getElementById("entry").value;
    var exit= document.getElementById("exit").value;
    var quantity= document.getElementById("quantity").value;


//if all required fields are filled
    if (!(ticker==""||entry==""||exit==""||quantity==""))
    {
	//add a new trade onto array
        new trade(ticker,entry,exit,quantity);
    }
	
	

    //call function to display the array
    print_table();

}

//this function creates an HTML table and populates with data from array
function print_table()
{

//decide where I'm going to print out
    var output_box=document.getElementById("output_box");

//creates the table
    var table=document.createElement("TABLE");

//creates the header row
    var header=table.createTHead();
    var headerRow = header.insertRow(0);

//populates header. There is definitely a more elegant way to do this.
//todo: elegant-ify. Maybe have an array of strings of things we want in the table? W/E Design thinks.
	headerRow.innerHTML="<th>Ticker</th><th>Entry Price</th><th>Exit Price</th><th>Quantity</th><th>Total Cost</th><th>Gross Income</th><th>Total Profit</th>";



//create temporary object for current element of array
    var TRADE;
//initialize
    var totalProfit = 0;

//for loop cycles through array
    for (var i=0; i<array.length; i++)
    {
        TRADE=array[i];

	//make a new row for entry
        var row = table.insertRow(0);
        //populate row - I have a better way to do this but first the object itself needs updating
	row.innerHTML="<td>"+TRADE.ticker+"</td><td>"+TRADE.entry+"</td><td>"+TRADE.exit+"</td><td>"+TRADE.quantity+"</td><td>"+TRADE.cost+"</td><td>"+TRADE.gross+"</td><td>"+TRADE.profit.toFixed(2)+"</td>";

	//add up the cash
        totalProfit+=TRADE.profit;

	//slap it on the end
        table.appendChild(row);

    }

	//This gives it the proper flag for CSS stylin'
	table.classList.add('journal_output_table');

    //clear output box
    output_box.innerHTML="";
    //display the table
    output_box.appendChild(table);

    //stick profit on the end - The slashes are nessecary for it to parse properly. Is there a more elegent way? Oh yes.
    output_box.innerHTML+="Total profit: <h4 style=\"display:inline\" id=\"profit\"></h5>";
    profit=document.getElementById("profit");

    //count the bills and make em pretty
    profit.innerHTML="$"+parseFloat(totalProfit).toFixed(2);

    //red is loss, green is profit. Break even is black
    if(totalProfit<0)
        profit.style.color="red";
    else if (totalProfit>0)
        profit.style.color="green";

}
