import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Input, Button, Card, CardBody, CardText, CardTitle, Col, Container, Form, FormGroup,Label,  Row } from "reactstrap";
import axios from 'axios';

function Signup(){

    const [status,setStatus]=useState('');
    const [responseBody,setResponseBody]=useState('');
    const [data,setData]=useState({
        name :'',
        schoolId: '',
        email :'',
        password :'',
        role :''
    });

    const handleSignup = async(event) =>{
        event.preventDefault();
        try {
                const response=await axios.post('http://localhost:8080/auth/signup',data);
                setStatus(response.status);
                setResponseBody(response.data); 
                alert("successfull");
             

                          
        } catch (error) {
            console.log(error);
            setStatus(error.response.status);
            setResponseBody(error.response.data);
            alert("unsuccessfull");
        }

    }
 
    const handleChange=(event,property)=>{
        setData({...data,[property]:event.target.value})

    }
    return(
   <>
   <Container>
    <Row className="mt-5">
    <Col sm={{size:6,offset:3}}>
        <Card>
            <CardBody>
                <CardTitle>Create Account</CardTitle>
                <CardText>
                    <Form onSubmit={handleSignup}>
                        <FormGroup>

                             {/* Name Section */}
                            <Label for="Name">
                                Name
                             </Label>
                                <Input
                                id="Name"
                                placeholder="Enter your Name "
                                onChange={(e)=>handleChange(e,'name')}
                                value={data.name}
                                />

                             {/* School Id Section */  }
                             <Label for="SchoolId">
                                School Id
                             </Label>
                             <Input
                                id="schoolId"
                                placeholder="Enter the Scool Id"
                                onChange={(e)=>handleChange(e,'schoolId')}
                                value={data.schoolId}
                             />

                              {/* email Section */}
                              <Label for="email">
                                Email
                             </Label>
                             <Input
                                id="email"
                                placeholder="Enter your Email"
                                onChange={(e)=>handleChange(e,'email')}
                                value={data.email}
                             />

                             {/* Password Section */}
                             <Label for="Password">
                                Password
                             </Label>
                             <Input
                                id="password"
                                placeholder="Enter your Password"
                                onChange={(e)=>handleChange(e,'password')}
                                value={data.password}
                                type="password"
                             />
                             
                              {/* Role Section */}
                                  <Label for="role">
                                    Role
                                  </Label>
                                  <Input
                                    id="role"
                                    placeholder="Select the role"
                                    onChange={(e)=>handleChange(e,'role')}
                                    value={data.role}
                                    type="select"
                                  >
                                    <option  >
                                     Teacher
                                    </option>
                                    <option>
                                      Student
                                  </option>
                                  </Input>
                        </FormGroup>
                            <Button color="danger" type="submit">
                            Signup

                            </Button>
                    </Form>

                </CardText>
                
            </CardBody>
        </Card>
    </Col>
        
    </Row>
   </Container>
   </>   
  

       
    )
}
export default Signup;