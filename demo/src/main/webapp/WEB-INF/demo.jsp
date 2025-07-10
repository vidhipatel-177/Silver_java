<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Cards</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <style>
        * {
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            margin: 0;
            padding: 20px;
            background-color: #f3f3f3;
        }

        .container {
            display: flex;
            gap: 20px;
            justify-content: center;
            flex-wrap: wrap;
        }

        .card {
            background: #fff;
            border-radius: 12px;
            padding: 20px;
            width: 180px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            transition: 0.3s ease-in-out;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        }

        .card img {
            width: 100%;
            height: 120px;
            object-fit: contain;
        }

        .title {
            font-weight: bold;
            font-size: 1.1em;
            margin-top: 10px;
            margin-bottom: 5px;
        }

        .description {
            font-size: 0.8em;
            color: #555;
            margin-bottom: 10px;
        }

        .price {
            font-weight: bold;
            margin-bottom: 10px;
        }

        .stars {
            color: orange;
            margin-bottom: 15px;
        }

        .btn {
            display: block;
            text-align: center;
            padding: 10px;
            border-radius: 5px;
            color: white;
            text-decoration: none;
            font-weight: bold;
            transition: background 0.3s;
        }

        .blue { background-color: #008CBA; }
        .blue:hover { background-color: #0079a1; }

        .purple { background-color: #474787; }
        .purple:hover { background-color: #3b3b6d; }

        .black { background-color: #000; }
        .black:hover { background-color: #222; }

        .orange { background-color: #FFA500; }
        .orange:hover { background-color: #e69500; }
    </style>
</head>
<body>

<div class="container">
    <!-- Card 1 -->
    <div class="card">
        <img src="https://via.placeholder.com/150x100?text=Shoes" alt="Shoes">
        <div class="title">Shoes</div>
        <div class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</div>
        <div class="price">$100.00</div>
        <div class="stars">★ ★ ★ ★ ☆</div>
        <a href="#" class="btn blue">Buy Now</a>
    </div>

    <!-- Card 2 -->
    <div class="card">
        <img src="https://via.placeholder.com/150x100?text=Earphone" alt="Earphone">
        <div class="title">Earphone</div>
        <div class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</div>
        <div class="price">$40.00</div>
        <div class="stars">★ ★ ★ ☆ ☆</div>
        <a href="#" class="btn purple">Buy Now</a>
    </div>

    <!-- Card 3 -->
    <div class="card">
        <img src="https://via.placeholder.com/150x100?text=Watch" alt="Watch">
        <div class="title">Watch</div>
        <div class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</div>
        <div class="price">$70.84</div>
        <div class="stars">★ ★ ★ ★ ☆</div>
        <a href="#" class="btn black">Buy Now</a>
    </div>

    <!-- Card 4 -->
    <div class="card">
        <img src="https://via.placeholder.com/150x100?text=Mobile" alt="Mobile">
        <div class="title">Mobile</div>
        <div class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</div>
        <div class="price">$1000.84</div>
        <div class="stars">★ ★ ★ ★ ★</div>
        <a href="#" class="btn orange">Buy Now</a>
    </div>
</div>

</body>
</html>
