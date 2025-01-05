const wrapper = document.querySelector(".slider-wrapper");
const menuItems = document.querySelectorAll(".menu-item")

const products = [
    {
        id: 1,
        title: "Ar Force",
        price: 100,
        colors: [
            {
                code: "black",
                img: "./images/airforce.png",
            },
            {
                code: "darkblue",
                img: "./images/air2.png",
            },
        ],
    },
    {
        id: 2,
        title: "Air Jordan",
        price: 100,
        colors: [
            {
                code: "lightgray",
                img: "./images/jordan.png",
            },
            {
                code: "green",
                img: "./images/jordan2.png",
            },
        ],
    },
    {
        id: 3,
        title: "Blazer",
        price: 100,
        colors: [
            {
                code: "lightgray",
                img: "./images/blazer.png",
            },
            {
                code: "green",
                img: "./images/blazer2.png",
            },
        ],
    },
    {
        id: 4,
        title: "Crater",
        price: 100,
        colors: [
            {
                code: "black",
                img: "./images/crater.png",
            },
            {
                code: "lightgray",
                img: "./images/crater2.png",
            },
        ],
    },
    {
        id: 5,
        title: "Hippie",
        price: 100,
        colors: [
            {
                code: "gray",
                img: "./images/hippie.png",
            },
            {
                code: "black",
                img: "./images/hippie2.png",
            },
        ],
    },
]

let chosenProduct = products[0]

const currProductImg = document.querySelector(".product-img");
const currProductTitle = document.querySelector(".product-title");
const currProductPrice = document.querySelector(".product-price");
const currProductColors = document.querySelectorAll(".color");
const currProductSizes = document.querySelectorAll(".size");

menuItems.forEach((item, index)=>{
    item.addEventListener("click", ()=>{
        //Change the current slide.
        wrapper.style.transform = `translateX(${-100 * index}vw`;

        //Change the chosen product.
        chosenProduct = products[index]

        //Change texts of current product
        currProductTitle.textContent = chosenProduct.title;
        currProductPrice.textContent = chosenProduct.price;
        currProductImg.src = chosenProduct.colors[0].img
        currProductColors.forEach((color,index)=>{
            color.style.backgroundColor = chosenProduct.colors[index].code;
        });


    });
});


currProductColors.forEach((color,index)=>{
    color.addEventListener("click", ()=>{
        currProductImg.src = chosenProduct.colors[index].img
    })
})

currProductSizes.forEach((size,index)=>{
    size.addEventListener("click", ()=>{
        currProductSizes.forEach((size)=>{
            size.style.backgroundColor = "white";
            size.style.color = "black";
        });
        size.style.backgroundColor = "black";
        size.style.color = "white";
    });
});

const productButton = document.querySelector(".product-button");
const payment = document.querySelector(".payment");
const close = document.querySelector(".close");

productButton.addEventListener("click",()=>{
    payment.style.display="flex";
});
close.addEventListener("click",()=>{
    payment.style.display="none";
});