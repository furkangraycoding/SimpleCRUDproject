import React, { Component } from 'react'
import InstructorService from '../services/InstructorService'

class ListInstructorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                instructors: []
        }
        this.addInstructor = this.addInstructor.bind(this);
        this.editInstructor= this.editInstructor.bind(this);
        this.deleteInstructor= this.deleteInstructor.bind(this);
    }

    deleteInstructor(id){
        InstructorService.deleteInstructor(id).then( res => {
            this.setState({instructors: this.state.instructors.filter(instructor => instructor.id !== id)});
        });
    }
    viewInstructor(id){
        this.props.history.push(`/view-instructors/${id}`);
    }
    editInstructor(id){
        this.props.history.push(`/add-instructors/${id}`);
    }

    componentDidMount(){
        InstructorService.getInstructors().then((res) => {
            this.setState({ instructors: res.data});
        });
    }

    addInstructor(){
        this.props.history.push('/add-instructors/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Instructors List</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addInstructor}> Add Instructor</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Instructor First Name</th>
                                    <th> Instructor Last Name</th>
                                    <th> Instructor Email</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.instructors.map(
                                        instructor =>
                                        <tr key = {instructor.id}>
                                             <td> { instructor.firstName} </td>
                                             <td> {instructor.lastName}</td>
                                             <td> {instructor.email}</td>
                                             <td>
                                                 <button onClick={ () => this.editInstructor(instructor.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteInstructor(instructor.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewInstructor(instructor.id)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListInstructorComponent
