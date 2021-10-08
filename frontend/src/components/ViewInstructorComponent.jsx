import React, { Component } from 'react'
import InstructorService from '../services/InstructorService'

class ViewInstructorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            instructor: {}
        }
    }

    componentDidMount(){
        InstructorService.getInstructorById(this.state.id).then( res => {
            this.setState({instructor: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Instructor Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Instructor First Name: </label>
                            <div> { this.state.instructor.firstName }</div>
                        </div>
                        <div className = "row">
                            <label> Instructor Last Name: </label>
                            <div> { this.state.instructor.lastName }</div>
                        </div>
                        <div className = "row">
                            <label> Instructor Email: </label>
                            <div> { this.state.instructor.email}</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewInstructorComponent
