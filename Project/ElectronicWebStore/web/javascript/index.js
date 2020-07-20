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
document.getElementById('filterBtn').addEventListener('click',hide);


function hide(){    
        document.getElementById("filterBtn").value='Show filter';
        document.getElementById('form').style.visibility='hidden';
        document.getElementById('filterBtn').removeEventListener('click',hide);
        document.getElementById('filterBtn').addEventListener('click',show);        
};
function show(){    
        document.getElementById('filterBtn').value='Hide filter';
        document.getElementById('form').style.visibility='visible';
        document.getElementById('filterBtn').removeEventListener('click',show);
        document.getElementById('filterBtn').addEventListener('click',hide);        
};

var btns=document.querySelectorAll('.buy');
for(let i=0;i<btns.length;i++){
    btns[i].addEventListener('click',addToBasket);
}

function addToBasket(){
    id=this.id;    
    let itemToAdd=getCommodity(id);    
    sessionStorage.setItem(sessionStorage.length,itemToAdd);
}
function arrToHTML(arr){
    let html='';
    for(let i=0;i<arr.length;i++){
      html+='<div id=\'basketItem\'>'+arr.getItem(i)+'</div>';      
    }
    return html;
}
function getCommodity(id){
  var result='';
  var className='.'+id+' #brandModel,'+'.'+id+' #price';
  var image='.'+id+' img';
  result+='<img src='+document.querySelector(image).src+'></img>';
  let characteristics=document.querySelectorAll(className);       
  characteristics.forEach(function(el){result+='<p>'+el.innerHTML+'</p>';});
  result+='<input type=\'button\' id=\'remove\' value=\'Remove\'>';
  return result;
}

let openBasketBtn=document.getElementById('basket');
let closeBasketBtn=document.getElementById('close');
let overlay=document.getElementById('overlay');
openBasketBtn.addEventListener('click',()=>{
    let basket=document.getElementById('popup_window');
    openBasket(basket);
});
closeBasketBtn.addEventListener('click',()=>{
    let basket=document.getElementById('popup_window');
    closeBasket(basket);
});
overlay.addEventListener('click', () => {
  const basket = document.getElementById('popup_window');  
  closeBasket(basket);  
});
function openBasket(basket){
    if(basket!==null){
        if(sessionStorage.length>0){
          document.getElementById('addedItems').innerHTML='Currently in basket:';
          document.getElementById('addedItems').innerHTML+=arrToHTML(sessionStorage);
        }
        basket.classList.add('active');
        overlay.classList.add('active');
    }
}
function closeBasket(basket){
    if(basket!==null){
        basket.classList.remove('active');
        overlay.classList.remove('active');
    }
}



