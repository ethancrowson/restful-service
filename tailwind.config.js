/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/**/*.{html,js,ico}"],
  theme: {
    extend: {
      colors: {
        'Foreground': '#1C274C', //Space Cadet
        'Background': '#F5F5F5', //White Smoke
        'Primary': '#BFC2CB', //French Gray
        'Secondary': '#535B77', //Ultra Violet
        'Tertiary':  '#899Ea1', //Cool Gray
        'input-bg': '#EFEFF0',
        'deft': '#384162',
      },
      transitionDuration: {
        '0ms': '0ms',
      },
    },
  },
  plugins: [],
}

