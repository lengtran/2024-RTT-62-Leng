document.addEventListener('DOMContentLoaded', function() {
  const signupForm = document.getElementById('signupForm');
  const signupEmail = document.getElementById('signupEmail');
  const signupPassword = document.getElementById('signupPassword');
  const confirmPassword = document.getElementById('confirmPassword');

  // Random messages array
  const randomMessages = [
    "Did you know cats sleep for an average of 15 hours a day?",
    "Dogs have an excellent sense of smell, up to 100,000 times more sensitive than humans.",
    "Birds are the only animals that have feathers.",
    "Goldfish can recognize and distinguish between different human faces.",
    "Hamsters love to run and can cover up to 8 miles in a single night on their wheel."
  ];

  // Function to log a random message every 3 seconds
  function logRandomMessage() {
    const randomIndex = Math.floor(Math.random() * randomMessages.length);
    console.log("Random Fact:", randomMessages[randomIndex]);
  }

  // Start logging random messages every 3 seconds
  const randomMessageInterval = setInterval(logRandomMessage, 3000);

  signupForm.addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission

    console.log('Form submission attempted.');

    // Validate email
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailRegex.test(signupEmail.value)) {
      displayError(signupEmail, 'Please enter a valid email address.');
      return;
    }

    console.log('Email validated:', signupEmail.value);

    // Validate password
    const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (!passwordRegex.test(signupPassword.value)) {
      displayError(signupPassword, 'Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one number.');
      return;
    }

    console.log('Password validated.');

    // Validate confirm password
    if (signupPassword.value !== confirmPassword.value) {
      displayError(confirmPassword, 'Passwords do not match.');
      return;
    }

    console.log('Passwords matched.');

    // If all validations pass, submit the form
    signupForm.submit();
  });

  // Function to display error message
  function displayError(inputElement, errorMessage) {
    const formText = inputElement.nextElementSibling;
    formText.style.color = 'red';
    formText.textContent = errorMessage;
  }

  // Clear error messages on input change
  signupEmail.addEventListener('input', function() {
    const formText = signupEmail.nextElementSibling;
    formText.textContent = '';
  });

  signupPassword.addEventListener('input', function() {
    const formText = signupPassword.nextElementSibling;
    formText.textContent = '';
  });

  confirmPassword.addEventListener('input', function() {
    const formText = confirmPassword.nextElementSibling;
    formText.textContent = '';
  });

  // Clear interval to stop random messages after form submission
  signupForm.addEventListener('submit', function() {
    clearInterval(randomMessageInterval);
  });

});
