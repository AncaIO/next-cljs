# Use shadow-cljs together with Next.js

The project allows you to define pages in with CLJS and Reagent and ouputs Next.js-compatible `.js` files. 

Based on [Thomas Heller's POC](https://github.com/thheller/next-cljs). 

This README and the project is a **work in progress**.

## Project structure

The CLJS files are located in the `src/main` directory. 

The Next.js-compatible page files are stored as follows:

- the files compiled  from `.cljs` to `.js` in `site/node_modules/shadow-cljs`.

- in `site/pages`, the JavaScript files that import the page definition function and supporting functions.

## Next.js feature support

The generated Next.js application supports the following:

- [x] [Custom _app definition](https://nextjs.org/docs/advanced-features/custom-app)

- [x] _app global style import support from aliased path
- [x] Support for [per-page layout definition](https://nextjs.org/docs/basic-features/layouts#per-page-layouts) or no layout
- [x] Support for simple [dynamic routes](https://nextjs.org/docs/routing/dynamic-routes)
- [x] Support for [server-side rendering](https://nextjs.org/docs/basic-features/data-fetching/get-server-side-props)
- [x] Support for [static generation](https://nextjs.org/docs/basic-features/data-fetching/get-static-props) of simple pages and dynamic routes
- [x] Next/Link & Next.js router
- [ ] CLJS components (not tested)
- [ ] Next/Image (not tested)
- [ ] Next.js middleware (not attempted)
- [ ] API routes (not attempted)
- [ ] Localized routes (not attempted)
- [ ] Localization libraries (not attempted)
- [ ] Client-side rendering with SWR, React hooks (not attempted)
- [ ] Re-frame


## Start the app for development

To develop using this application:
1. Click **Use this template** to create a repository based on the template.
2. Clone the repository on your machine.
3. Change the directory to your project directory and run the following commands:
  ```
    npm install
    npx shadow-cljs watch site
  ```
4. In another terminal, start the development server for the Next.js app:
  ```
    cd site
    npm install
    npm run dev
  ```
5. Open the browser to [http://localhost:3000](http://localhost:3000)


## Build the app

To build the app:

1. In the root folder of your project run the following commands to compile optimized JavaScript files:
  ```
    npx shadow-cljs release site
    
  ```
2. When done, build the Next.js app for production:
  ```
    cd site
    npm run build
  ```

3. To inspect the production build, start the production server:
  ```
    npm run start  
  ```
4. Open the browser to [http://localhost:3000](http://localhost:3000)
