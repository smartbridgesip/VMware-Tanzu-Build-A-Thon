import React, { Component } from 'react';
import ListStudentsComponent from './ListStudentsComponent';

class StudentApp extends Component {
    render() {
        return (<>
              <h1>Student Application</h1>
              <ListStudentsComponent/>
              </>
        )
    }
}

export default StudentApp