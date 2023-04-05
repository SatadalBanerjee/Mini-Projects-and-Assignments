import React,{useState} from 'react'

export default function TextForm(props) {
    const [text, setText] = useState("Enter Text Here");

    return (
    <div>
        <h1>{props.heading}</h1>
        <div class="mb-3">
        <textarea class="form-control" id="exampleFormControlTextarea1" value={text} rows="8"></textarea>
        </div>  
        <button className="btn btn-primary">Convert TO UpperCase</button>
    </div>
  )
}

