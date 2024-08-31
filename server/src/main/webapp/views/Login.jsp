<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
    <div class="container">
        <div class="mx-auto mt-5 p-2" style="width: 400px;">
                <div class="login-card-light  p-3 shadow-lg rounded">
                    <div class="pt-3 ">
                       
                        <img src="https://img.icons8.com/color/96/000000/user-male-circle.png" class="rounded mx-auto d-block">
                   <h3 class="text-center" > VPS School </h3>
                   
                    </div>
    
                    <form class="mt-5">
                     
                        <div class="form-group">
                            
                            <input type="email" 
                                class="form-control form-control" 
                                placeholder="School Id">
                        </div>
                        <br>
                        <div class="form-group">
                            <input type="password" 
                                class="form-control form-control" 
                                placeholder="Password">
                        </div>
                        <br>

                        <div class="form-group">
                            <button class="btn btn-sm btn-danger col">
                                Login
                            </button>
                        </div>
                        <div class=" mt-5">
                            <a class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover" href="signup">
								  Don't Account? Signup
							</a>
                        </div>
                       
    
                        
                    </form>
                </div>
            </div>
    
            
    </div>
       
   
</body>
</html>