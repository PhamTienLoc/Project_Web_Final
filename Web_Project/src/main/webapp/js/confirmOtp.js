window.onload = function () {
        let timeLeft = 300; // 5 minutes in seconds
        const countdownElement = document.getElementById('countdown');
        const resendLinkElement = document.getElementById('resend-link');

        const countdown = setInterval(() => {
            const minutes = Math.floor(timeLeft / 60);
            const seconds = timeLeft % 60;
            countdownElement.textContent = `Thời gian còn lại: ${minutes}:${seconds.toString().padStart(2, '0')}`;

            timeLeft--;

            if (timeLeft < 0) {
                clearInterval(countdown);
                countdownElement.textContent = "Đếm ngược kết thúc!";
                resendLinkElement.style.display = 'block'; // Hiển thị nút gửi lại mã OTP
            }
        }, 1000);
    };