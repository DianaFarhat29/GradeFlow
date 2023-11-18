/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.html'],
  theme: {
    extend: { colors: {
        greenLogo: '#7DE663',
        greyBack: '#CACFD2',
        grayList:'#F9FAFB',
        greenLogoTint: '#97eb82',
        greenLogoTintPale: '#b1f0a1',
      },
      fontFamily: {
        'mainFont': ['Quicksand', 'sans-serif'],
      },
    },
  },
  plugins: [],
}

