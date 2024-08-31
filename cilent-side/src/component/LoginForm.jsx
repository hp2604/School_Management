import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import { setToken } from "../service/JwtToken";
import {
  Input,
  Button,
  Container,
  Row,
  Col,
  Card,
  CardBody,
  CardTitle,
  CardText,
  Form,
  FormGroup,
  Label,
} from "reactstrap";
import { toast } from "react-toastify";

function Login() {
  const [data, setData] = useState({
    schoolId: "",
    password: "",
    role: "",
  });
  const handleChange = (event, property) => {
    setData({ ...data, [property]: event.target.value });
  };

  const handleLogin = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8080/auth/login",
        data
      );
      const status = response.status;
      const responseBody = response.data;
      if (status == 202) {
        setToken(responseBody);
        toast.success("login Successful");
      } else if (status == 401) {
        toast.error(responseBody);
      }
    } catch (error) {
      toast.error("Something went wrong ");
    }
  };

  return (
    <>
      <Container>
        <Row className="mt-5">
          <Col sm={{ size: 6, offset: 3 }}>
            <Card>
              <CardBody>
                <CardTitle>
                  <h4> Login</h4>
                </CardTitle>
                <CardText>
                  <Form onSubmit={handleLogin}>
                    {/* School Id section*/}
                    <FormGroup>
                      <Label for="School Id">School Id</Label>
                      <Input
                        id="schoolId"
                        placeholder="Enter your School Id"
                        onChange={(e) => handleChange(e, "schoolId")}
                        value={data.schoolId}
                        required
                      />
                    </FormGroup>

                    {/* Password Section  */}
                    <FormGroup>
                      <Label for="password">Password</Label>
                      <Input
                        id="password"
                        type="password"
                        placeholder="Enter your Password "
                        onChange={(e) => handleChange(e, "password")}
                        value={data.password}
                        required
                      />
                    </FormGroup>
                    <FormGroup>
                      <Label for="role">Role</Label>
                      <Input
                        id="role"
                        placeholder="Select the role"
                        onChange={(e) => handleChange(e, "role")}
                        value={data.role}
                        type="select"
                        required
                      >
                        <option value={"Teacher"}>Teacher</option>
                        <option value={"Student"}>Student</option>
                      </Input>
                    </FormGroup>

                    <Button color="danger" type="submit">
                      Login
                    </Button>
                  </Form>
                  <br></br>
                  <a href="signup">Don't Account Signup</a>
                </CardText>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
}
export default Login;
