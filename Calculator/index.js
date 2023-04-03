  var keys= document.querySelectorAll("#keyboard>div");
  var bag="";

  for(var a=0;a<keys.length;a++)
  {
      keys[a].addEventListener("click",myCalculator)
  }

  function myCalculator()
  {
      var targetNumber=event.target.innerText;

      if(targetNumber =="C"){
          bag="";
        document.querySelector("#display").innerText="";
      }
      else if(targetNumber == "="){
          document.querySelector("#display").innerText=eval(bag);
      }
      else{
      bag = bag+targetNumber;
      document.querySelector("#display").innerText=bag;
      }
  }
