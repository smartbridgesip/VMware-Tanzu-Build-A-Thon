import axios from 'axios'

const COURSE_API_URL = 'http://localhost:8080'
const INSTRUCTOR_API_URL = `${COURSE_API_URL}/students/all`

class StudentDataService {

    retrieveAllStudents() {
        return axios.get(INSTRUCTOR_API_URL);
    }
}

export default new StudentDataService()