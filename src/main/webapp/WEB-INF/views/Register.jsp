<form action="./registerProcess">
    <div class="Registercontainer">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <h5>${error}</h5>
        <label for="email"><b>Username</b></label>
        <input class="textf" type="text" placeholder="Enter Username"name="UserName" required>
        <label for="psw"><b>Password</b></label>
        <input class="passworddf" type="password" placeholder="Enter Password" name="Password" required>

        <label for="psw-repeat"><b>Full Name</b></label>
        <input class="passwordf" type="text" placeholder="Full Name" name="FullName" required>
        <hr>

        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="http://localhost:8080/onlineshopping/Login">Sign in</a>.</p>
    </div>
</form>