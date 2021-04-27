import React, { Component } from 'react';
import StudentDataService from '../Service/StudentDataService';

class ListStudentsComponent extends Component {
    constructor() {
        super()
        this.state = {
            students: [],
            message: null
        }
        this.refreshCourses = this.refreshCourses.bind(this)
    }

    componentDidMount() {
        this.refreshCourses();
    }

    refreshCourses() {
        StudentDataService.retrieveAllStudents()//HARDCODED
            .then(
                response => {
                    console.log(response);
                    this.setState({ students: response.data })
                }
            )
    }

    render() {
        return (
            <div className="container">
                <h3>All Students</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Roll No</th>
                                <th>Name</th>
                                <th>Courses</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.students.map(
                                    student =>
                                    <tr key={student.rollNo}>
                                    <td>{student.rollNo}</td>
                                    <td>{student.name}</td>
                                    <td>{student.course}</td>
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
export default ListStudentsComponent