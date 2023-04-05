import React,{useState} from 'react'

export default function TextForm(props) {
    const [text, setText] = useState("Enter Text Here");
    
    const handleClick = () =>{
        let newText = text.toUpperCase();
        setText(newText);
    }

    const handleOnChange = (event) =>{
        setText(event.target.value);
    }

    return ( 
    <div>
        <h1>{props.heading}</h1>
        <div class="mb-3">
        <textarea class="form-control" id="exampleFormControlTextarea1" value={text} onChange={handleOnChange} rows="8"></textarea>
        </div>  
        <button className="btn btn-primary" onClick={handleClick}>Convert TO UpperCase</button>
    </div>
  )
}

