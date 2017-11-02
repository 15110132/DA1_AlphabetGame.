/**
 * 
 */

    var cook;
    var carts = [];
 
    var i;
    var txt;
    function cart(productId)
    {
    	carts.push(productId);
    	alert(carts);
    	document.getElementById("total_items").innerHTML = carts.length;
//    	document.getElementById("carts").value = carts;
    	for (i =0 ; i< carts.length; i++){
    		txt+= "carts="+carts[i]+"&"
    	}
    	document.getElementById("btnCart").href="/FindFood/showCart?"+txt
    	
    	
    }
    function show_cart()
    {
    	for (i = 0; i < carts.length; i++) {
    		"<div class='cart_items'>";
    	      
    	      "<p>carts[i]</p>";
    	     
    	      "</div>";
    	      alert(carts[i]);
    	}
    	
    }



