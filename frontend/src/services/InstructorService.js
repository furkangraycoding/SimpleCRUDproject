import axios from 'axios';

const INSTRUCTOR_API_BASE_URL = "http://localhost:8080/api/v1/instructors";

class InstructorService {

    getInstructors(){
        return axios.get(INSTRUCTOR_API_BASE_URL);
    }

    createInstructor(instructor){
        return axios.post(INSTRUCTOR_API_BASE_URL, instructor);
    }

    getInstructorById(instructorId){
        return axios.get(INSTRUCTOR_API_BASE_URL + '/' + instructorId);
    }

    updateInstructor(instructor, instructorId){
        return axios.put(INSTRUCTOR_API_BASE_URL + '/' + instructorId, instructor);
    }

    deleteInstructor(instructorId){
        return axios.delete(INSTRUCTOR_API_BASE_URL + '/' + instructorId);
    }
}

export default new InstructorService()