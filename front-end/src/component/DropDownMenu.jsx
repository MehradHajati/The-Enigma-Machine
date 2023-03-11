import React, { useState } from 'react';

function DropdownMenu() {
  const [selectedOption, setSelectedOption] = useState('');

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Send a request to the backend with the selected option value
    fetch('/encrypt', {
      method: 'POST',
      body: JSON.stringify({ selectedOption }),
    })
      .then((response) => response.json())
      .then((data) => console.log(data))
      .catch((error) => console.error(error));
  };

  return (
    <div className='scrollbar-hide w-full h-screen bg-[#0a192f] flex justify-center items-center p-4'>
    <div name='cipher' className='scrollbar-hide w-full h-screen bg-[#0a192f] flex justify-center items-center p-4'>
      <form method='POST' className='flex flex-col max-w-[600px] w-full'>
          <div className='pb-8'>
              <p className='text-4xl font-bold inline border-b-4 border-pink-600 text-gray-300'>CIPHER</p>
              <div className='pt-8'>
                <p className='text-xl font-bold inline text-gray-300 pr-4'>
                  Please choose an encryption method
                </p>
                <select className='pr-4 text-xl font-bold inline text-black'>
                <option>Orange</option>
                <option>Blue</option>
                <option>Red</option>
                </select>
                <p>{`You selected`}</p>
              </div>
              <p className='text-gray-300 py-4 font-bold'>Enter plaintext:</p>
          </div>
          <input className='bg-[#ccd6f6] p-2' type="text" placeholder='PlainText' name='name' />
          <button className='text-white border-2 hover:bg-pink-600 hover:border-pink-600 px-4 py-3 my-8 mx-auto flex items-center'>Encrypt</button>
      </form>
  </div>
  </div>
  );
}

export default DropdownMenu;