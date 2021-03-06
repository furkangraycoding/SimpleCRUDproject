import React, { Component } from 'react'
import InstructorService from '../services/InstructorService';

class CreateInstructorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            firstName: '',
            lastName: '',
            email: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.saveOrUpdateInstructor = this.saveOrUpdateInstructor.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            InstructorService.getInstructorById(this.state.id).then( (res) =>{
                let instructor = res.data;
                this.setState({firstName: instructor.firstName,
                    lastName: instructor.lastName,
                    email : instructor.email
                });
            });
        }        
    }
    saveOrUpdateInstructor = (e) => {
        e.preventDefault();
        let instructor = {firstName: this.state.firstName, lastName: this.state.lastName, email: this.state.email};
        console.log('instructor => ' + JSON.stringify(instructor));

        // step 5
        if(this.state.id === '_add'){
            InstructorService.createInstructor(instructor).then(res =>{
                this.props.history.push('/instructors');
            });
        }else{
            InstructorService.updateInstructor(instructor, this.state.id).then( res => {
                this.props.history.push('/instructors');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Instructor</h3>
        }else{
            return <h3 className="text-center">Update Instructor</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> First Name: </label>
                                            <input placeholder="Furkan" name="firstName" className="form-control"
                                                value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Last Name: </label>
                                            <input placeholder="G??r??ay" name="lastName" className="form-control"
                                                value={this.state.lastName} onChange={this.changeLastNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Email: </label>
                                            <input placeholder="blabla@gmail.com" name="email" className="form-control"
                                                value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateInstructor}>Save</button>
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

export default CreateInstructorComponent
