const searchBtn = document.querySelector("#search-btn");
const cancelBtn = document.querySelector("#cancel-btn");
const searchBox = document.querySelector("#search-box");
const searchInput = document.querySelector("#search-input");

searchBtn.onclick = () => {
    searchInput.classList.remove("opacity-0");
    searchInput.classList.add("opacity-100");

    cancelBtn.classList.remove("opacity-0");
    cancelBtn.classList.add("opacity-100");
}

cancelBtn.onclick = () => {
    searchInput.classList.add("opacity-0");
    searchInput.classList.remove("opacity-100");

    cancelBtn.classList.add("opacity-0");
    cancelBtn.classList.remove("opacity-100");
}
document.addEventListener("DOMContentLoaded", () => {
    const track = document.getElementById("carousel-track");
    const prevButton = document.getElementById("prev-btn");
    const nextButton = document.getElementById("next-btn");

    const items = Array.from(track.children); // All carousel items
    const itemWidth = items[0].getBoundingClientRect().width +32; // Get item width
    const totalItems = items.length+6;

    // Clone items for infinite scrolling
    const cloneFirst = items.slice(0, 5).map(item => item.cloneNode(true)); // First 2 items
    const cloneLast = items.slice(-5).map(item => item.cloneNode(true)); // Last 2 items
    cloneFirst.forEach(item => track.appendChild(item));
    cloneLast.reverse().forEach(item => track.insertBefore(item, track.firstChild));

    let currentSlide = 6; // Start on the third item to center the view

    // Adjust carousel to center the starting position
    const adjustInitialPosition = () => {
        currentSlide = 6;
        track.style.transition = "none"; // Disable animation during initial setup
        track.style.transform = `translateX(${-itemWidth * currentSlide}px)`; // Center on the third item
    };

    // Helper to update the carousel's position
    const updateCarouselPosition = () => {
        track.style.transition = "transform 0.5s ease-in-out"; // Smooth animation
        track.style.transform = `translateX(${-itemWidth * currentSlide}px)`; // Adjust position
    };

    // Move to the next slide
    const moveToNextSlide = () => {
        if (currentSlide < totalItems - 1) {
            currentSlide += 1;
            updateCarouselPosition();
        } else {
            //If at the last slide, loop back to the first real slide
            setTimeout(() => {
                adjustInitialPosition();
            }, 500);
            currentSlide += 1;
            updateCarouselPosition();
        }
    };

    // Move to the previous slide
    const moveToPrevSlide = () => {
        if (currentSlide > 1) {
            currentSlide -= 1;
            updateCarouselPosition();
        } else {
            // If at the first slide, loop back to the last real slide
            setTimeout(() => {
                adjustInitialPosition();
            }, 500);
            currentSlide -= 1;
            updateCarouselPosition();
        }
    };

    // Event listeners for buttons
    nextButton.addEventListener("click", moveToNextSlide);
    prevButton.addEventListener("click", moveToPrevSlide);

    // Initialize position
    adjustInitialPosition();

});