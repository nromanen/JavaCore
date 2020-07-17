/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let minPriceSlider=document.getElementById("minPrice");
var minPriceOutput=document.getElementById("minPriceValue");
minPriceOutput.innerHTML=minPriceSlider.value;
if(minPriceSlider){
  minPriceSlider.addEventListener('change',function(){    
    minPriceOutput.innerHTML=this.value;  
  },false);
}
var maxPriceSlider=document.getElementById("maxPrice");
var maxPriceOutput=document.getElementById("maxPriceValue");
maxPriceOutput.innerHTML=maxPriceSlider.value;
maxPriceSlider.oninput=function(){    
  maxPriceOutput.innerHTML=this.value;  
};
//let filterBtn=document.getElementById("filterBtn");
//let form=document.getElementById("form");
document.getElementById('filterBtn').addEventListener('click',hide);


function hide(){
    //if(document.getElementById("filterBtn").innerHTML==='Show filter'){
        document.getElementById("filterBtn").value='Show filter';
        document.getElementById('form').style.visibility='hidden';
        document.getElementById('filterBtn').removeEventListener('click',hide);
        document.getElementById('filterBtn').addEventListener('click',show);
        //form.style.visibility='visible';
    //}
};
function show(){
    //if(document.getElementById("filterBtn").innerHTML==='Hide filter'){
        document.getElementById('filterBtn').value='Hide filter';
        document.getElementById('form').style.visibility='visible';
        document.getElementById('filterBtn').removeEventListener('click',show);
        document.getElementById('filterBtn').addEventListener('click',hide);
        //form.style.visibility='hidden';
    //}
};



