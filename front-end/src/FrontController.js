import React, { Component } from "react";
import {Client} from '@stomp/stompjs';
import DropDownMenu from "./component/DropDownMenu";


//const SOCKET_URL = 'ws://localhost:8080/ws-message';


class FrontController extends Component {

//   sendPostRequest = (endpoint, body) => {
//     const requestOptions = {
//         method: 'POST',
//         headers: { 
//             'Content-Type': 'application/json',
//         },
//         body
//     };

//     console.log("request body: " + JSON.stringify(body));
//     fetch(`http://localhost:8080${endpoint}`, requestOptions)
//         .then(res => {
//             if (res.status === 400){
//                 res.json().then(parsed => {console.log(parsed)})
//                 // console.log(res);
//             }
//         })
//   }

//   encryptMessage = (message_to_encrypt) => {
//     let body = {
//       message: message_to_encrypt
//     };
//     this.sendPostRequest("/encrypt", JSON.stringify(body))
//     fetch('http://localhost:8080/encrypted')
//     .then(res => {
//       if (res.status === 404){
//           console.log(res);
//           return null;
//       }
//       else if (res.ok){
//           res.json()
//               .then(body => console.log("BODYYYY: " + JSON.stringify(body)))
//               // .then(this.setState({myPlayerNum: this.state.playerList.length}));
//       }
//   })
// }

// // WebSocket setup 
// componentDidMount(){
//   let onConnected = () => {
//       console.log("connected");
//       client.subscribe("/encrypted/encrypt", (res) => {
//           if (res.body && this.state.myPlayerId){
//               this.setGameState(JSON.parse(res.body));
//           }
//           else{
//               console.log("No response");
//           }
//       });
//   }

//   let onDisconnected = () => {
//       console.log("disconnected");
//   }

//   const client = new Client({
//       brokerURL: SOCKET_URL,
//       reconnectDelay: 5000,
//       heartbeatIncoming: 4000,
//       heartbeatOutgoing: 4000,
//       onConnect: onConnected,
//       onDisconnect: onDisconnected
//   });
//   client.activate();
// }



render() {
  return (
    <div className='scrollbar-hide w-full h-screen bg-[#0a192f] flex justify-center items-center p-4'>
      <DropDownMenu>
      </DropDownMenu>
    </div>
  );
}
}

export default FrontController;