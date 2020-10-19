const jsonServer = require('json-server')
const server = jsonServer.create()
const router = jsonServer.router('Book.json')
const middlewares = jsonServer.defaults()
 
server.use(middlewares)
server.use(router)
server.use(jsonServer.rewriter({
	  '/': '/',
    '/api/book': '/book',
  '/api/book/:id': '/book/:id'
}));
server.get('/book', (req, res) => {
 
  res.status(400).jsonp({
    error: "No valid userId"
  });

});
server.listen(3000, () => {
  console.log('JSON Server is running')
})