import React from 'react';
import { Component } from 'react';

class DropdownMenu extends Component {

  render() {
  
    return (
      <React.Fragment>
      <div className='scrollbar-hide w-full h-screen bg-[#0a192f] flex justify-center items-center p-4'>
      <div name='cipher' className='scrollbar-hide w-full h-screen bg-[#0a192f] flex justify-center items-center p-4'>
        <form method='POST' className='flex flex-col max-w-[600px] w-full'>
            <div className='pb-8'>
                <p className='text-4xl font-bold inline border-b-4 border-pink-600 text-gray-300'>CIPHER</p>
                <div className='pt-8'>
                  <p className='text-xl font-bold inline text-gray-300 pr-4'>
                    Please choose an encryption method
                  </p>
                  <select className='pr-4 text-xl font-bold inline text-black' cipher={this.props.cipher} setType={(type) => {this.props.setType(type)}}>
                  <option>Affine</option>
                  <option>Atbash</option>
                  <option>Caesar</option>
                  <option>Huffman</option>
                  <option>Matrix</option>
                  <option>Railfence</option>
                  <option>Vigenere</option>
                  </select>
                </div>
                <p className='text-gray-300 py-4 font-bold'>Enter plaintext:</p>
            </div>
            <input className='bg-[#ccd6f6] p-2' type="text" placeholder='PlainText' name='name' cipher={this.props.cipher} setMessage={(message) => {this.props.setMessage(message)}}/>
            <button className='text-white border-2 hover:bg-pink-600 hover:border-pink-600 px-4 py-3 my-8 mx-auto flex items-center' cipher={this.props.cipher} encrypt={() => {this.props.encrypt()}}>Encrypt</button>
        </form>
    </div>
    </div>
    </React.Fragment>
    );
  }
}

export default DropdownMenu;