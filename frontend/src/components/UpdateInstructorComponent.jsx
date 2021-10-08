import React, { Component } from 'react'
import InstructorService from '../services/InstructorService';

class UpdateInstructorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            firstName: '',
            lastName: '',
            email: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.updateInstructor = this.updateInstructor.bind(this);
    }

    componentDidMount(){
        InstructorService.getInstructorById(this.state.id).then( (res) =>{
            let instructor = res.data;
            this.setState({firstName: instructor.firstName,
                lastName: instructor.lastName,
                email : instructor.email
            });
        });
    }

    updateInstructor = (e) => {
        e.preventDefault();
        let instructor = {firstName: this.state.firstName, lastName: this.state.lastName, email: this.state.email};
        console.log('instructor => ' + JSON.stringify(instructor));
        console.log('id => ' + JSON.stringify(this.state.id));
        InstructorService.updateInstructor(instructor, this.state.id).then( res => {
            this.props.history.push('/instructors');
        });
    }
    
    changeFirstNameHandler= (event) => {
        this.setState({firstName: event.target.value});
    }

    changeLastNameHandler= (event) => {
        this.setState({lastName: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    cancel(){
        this.props.history.push('/instructors');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Instructor</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> First Name: </label>
                                            <input placeholder="Furkan" name="firstName" className="form-control"
                                                value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Last Name: </label>
                                            <input placeholder="Gürçay" name="lastName" className="form-control"
                                                value={this.state.lastName} onChange={this.changeLastNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Email: </label>
                                            <input placeholder="blabla@gmail.com" name="email" className="form-control"
                                                value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateInstructor}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateInstructorComponent
