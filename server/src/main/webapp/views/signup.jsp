<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <div class="mx-auto mt-5 p-2" style="width: 400px;">
                <div class="login-card-light  p-3 shadow-lg rounded">
                    <div class="pt-3 ">
                        <img src="https://img.icons8.com/cotton/64/000000/groups--v1.png" class="rounded mx-auto d-block" >
                    </div>
    
                    <form class="mt-5">
                        <div class="form-group">
                            <input type="text" 
                                class="form-control form-control" 
                                placeholder="Name">
                        </div>
                        <br>

                        <div class="form-group">
                            
                            <input type="number" 
                                class="form-control form-control" 
                                placeholder="School Id">
                        </div>
                        <br>

                        <div class="form-group">
                            
                            <input type="email" 
                                class="form-control form-control" 
                                placeholder="Email">
                        </div>
                        <br>

                        <div class="form-group">
                            <input type="password" 
                                class="form-control form-control" 
                                placeholder="Password">
                        </div>
                        <br>

                        <div class="form-group">
                            <input type="password" 
                                class="form-control form-control" 
                                placeholder=" Confirm Password">
                        </div>
    
                       
                        <div class="mt-5">
                            <button class="btn btn-sm btn-danger col">
                                Sign Up
                            </button>
                        </div>
    
                        
                    </form>
                </div>
            </div>
    
            
    </div>
       
</body>
</html>