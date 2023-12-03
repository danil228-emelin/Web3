var finalX = 0;
var finalY = 0;
canvas = document.getElementById("canvas");
el = document.getElementById('graphic');
canvas.addEventListener('click', () => {
    drawPoint(ctx, 'yellow', 5)
})
var pixelValue = 6.5;
var width = canvas.getBoundingClientRect().width;
var height = canvas.getBoundingClientRect().height

function drawPoint(context, color, size) {
    let x = finalX
    let y = finalY;
    let r = parseFloat(document.getElementById("R:R_input_input").value);
    console.log("x", x);
    console.log("y", y);
    console.log("r", r);

    let radius = 0.5 * size;
    let pointX = Math.round(x - radius);
    let pointY = Math.round(y - radius);
    redrawElement(color)
    let requestX = Math.round((x - width / 2) / pixelValue);
    let requestY = Math.round((height / 2 - y) / pixelValue);

    let currentTime = new Date().toLocaleString("ru-RU", {
        timeZone: "Europe/Moscow",
        hour: "numeric",
        minute: "numeric",
        second: "numeric",
    });
    console.log("pointX:", pointX);
    console.log("pointY:", pointY);
    console.log("requestX", requestX);
    console.log("requestY", requestY);
    console.log("requestR", r*pixelValue);
    res = isInRange(requestX, requestY, r * pixelValue);
    if (res) {
        console.log("YES")
        context.stroke();
        redrawElement('#0ce53f')
        context.fill();
    } else {
        console.log("NO")
        redrawElement('#e5350c')
        context.fill();
    }
    function redrawElement(color) {
        context.beginPath();
        context.fillStyle = color;
        context.fillRect(pointX, pointY, size, size);
    }
}
canvas.addEventListener('mousedown', function (e) {
    getCursorPosition(canvas, e);
})

function getCursorPosition(canvas, event) {
    const rect = canvas.getBoundingClientRect()
    finalX = event.clientX - rect.left;
    finalY = event.clientY - rect.top;
}

function isInRange(x, y, r) {
    return isInRectangle(x, y, r) || isInSquare(x, y, r) || isInCircle(x, y, r);
}

function isInRectangle(x, y, r) {
    return x <= r && x >= 0 && y <= r / 2 && y >= 0;
}

function isInCircle(x, y, r) {
    return x >= -r / 2 && x <= 0 && y <= r / 2 && y >= 0;
}

function isInSquare(x, y, r) {
    return x <= r && x >= 0 && y >= -r / 2 && y <= 0;
}

