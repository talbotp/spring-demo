import React from 'react';
import API from './API'
import axios from 'axios';

class JoinComponent extends React.Component {

    constructor() {
        super();
        this.state = {username: ''};
    }

    nameChangedHandler = (event) => {
        this.setState({username: event.target.value});
    }

    joinHandler = async () => {
        // API.get("/t1").then(
        //     response => {
        //         alert('success');
        //     },
        //     error => {
        //         console.log('potatoes');
        //         console.log(error);
        //     }
        // );
        try {
            const response = await axios.get('http://localhost:8080/t1');
            // Success 🎉http://localhost:8080/t1
            console.log(response);
        } catch (error) {
            // Error 😨
            if (error.response) {
                /*
                 * The request was made and the server responded with a
                 * status code that falls out of the range of 2xx
                 */
                console.log("1")
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
            } else if (error.request) {
                /*
                 * The request was made but no response was received, `error.request`
                 * is an instance of XMLHttpRequest in the browser and an instance
                 * of http.ClientRequest in Node.js
                 */
                console.log("2")
                console.log(error.request);
            } else {
                console.log("3")
                // Something happened in setting up the request and triggered an Error
                console.log('Error', error.message);
            }
            console.log(error);
        }
    }

    render() {
        return (
          <form onSubmit={this.joinHandler}>
            <input type='text' onChange={this.nameChangedHandler}/>
            <input type='submit'/>
          </form>);
    }

}

export default JoinComponent;