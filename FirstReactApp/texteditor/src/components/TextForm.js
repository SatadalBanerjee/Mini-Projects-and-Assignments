import React,{useState} from 'react'

export default function TextForm(props) {
    const [text, setText] = useState("");
    
    const handleClick = () =>{
        let newText = text.toUpperCase();
        setText(newText);
    }

    const handleClickLo = () =>{
        let newText = text.toLowerCase();
        setText(newText);
    }
    const handleOnChange = (event) =>{
        setText(event.target.value);
    }

    const textClearer =()=> {
        setText("");
    }

    const textToSpeech = () => {
        const Speech= new SpeechSynthesisUtterance();
        const message= text;

        Speech.lang='eng';
        Speech.text= message;
        window.speechSynthesis.speak(Speech);
    }

    return ( 
        <>
    <div className='container'>
        <h1>{props.heading}</h1>
        <div class="mb-3">
        <textarea class="form-control" id="exampleFormControlTextarea1" value={text} onChange={handleOnChange} rows="8"></textarea>
        </div>  
        <button className="btn btn-primary mx-2" onClick={handleClick}>Convert To UpperCase</button>
        <button className="btn btn-primary mx-2" onClick={handleClickLo}>Convert To LowerCase</button>
        <button className="btn btn-primary mx-2" onClick={textToSpeech}>Hear the text</button>
        <button className="btn btn-primary mx-2" onClick={textClearer}>Clear Text</button>
    </div>
    <div className="container my-5">
        <h1>Your Text Summary</h1>
        <p>{text.split(" ").length} words and {text.length} characters</p>
        <p>Can be read in {0.010 * text.split(" ").length} minutes</p>

        <h2>Preview</h2>
        <p>{text}</p>
    </div>
    </>
  )
}

