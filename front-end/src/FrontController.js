import React, { Component } from "react";
import DropDownMenu from "./component/DropDownMenu";


//const SOCKET_URL = 'ws://localhost:8080/ws-message';


class FrontController extends Component {

  cipher = {
    type: "",
    message: "",
    key: ""
  }

  sendPostRequest = (endpoint, body) => {
    console.log(body)
    const requestOptions = {
        method: 'POST',
        headers: { 
            'Content-Type': 'application/json',
        },
        body
    };
    console.log("request body: " + JSON.stringify(body));
    fetch(`http://localhost:8080${endpoint}`, requestOptions)
        .then(res => {
            if (res.status === 400){
                res.json().then(parsed => {console.log(parsed)})
                // console.log(res);
            }
        })
}

encrypt = () => {
  let body = {
    encryptType: this.cipher.type,
    message: this.cipher.message
};
this.sendPostRequest("/encrypt", JSON.stringify(body));
}

decrypt = () => {
  let body = {
    decryptType: this.cipher.type,
    message: this.cipher.message,
    key: this.cipher.key
};
this.sendPostRequest("/decrypt", JSON.stringify(body));
}

setType = (type) => {
  this.cipher.type = type;
}

setMessage = (message) => {
  this.cipher.message = message;
}

setKey = (key) => {
  this.cipher.key = key;
}


render() {
  return (
    <div className='scrollbar-hide w-full h-screen bg-[#0a192f] flex justify-center items-center p-4'>
      <DropDownMenu cipher={this.cipher} setType={this.setType} setMessage={this.setMessage} setKey={this.setKey}>
      </DropDownMenu>
    </div>
  );
}
}

export default FrontController;